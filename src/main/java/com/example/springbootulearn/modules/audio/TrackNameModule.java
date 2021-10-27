package com.example.springbootulearn.modules.audio;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import com.example.springbootulearn.FileUtil;
import org.apache.tika.parser.audio.AudioParser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParseContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class TrackNameModule extends AbstractAudioModule{ //очередная магия Интернета
    @Override
    public String describeFunction() {
        return "Вывод названия трека из тегов";
    }

    @Override
    public void function(File file) {
        try (InputStream input = new FileInputStream(file)) {
            Parser parser;
            if (FileUtil.getFileUtils(file.getName()).equals("mp3"))
                parser = new Mp3Parser();
            else
                parser = new AudioParser();

            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            ParseContext parseCtx = new ParseContext();
            parser.getSupportedTypes(parseCtx);

            parser.parse(input, handler, metadata, parseCtx);

            printSongTitle(metadata);

        } catch (IOException | SAXException | TikaException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }

    private void printSongTitle(org.apache.tika.metadata.Metadata metadata) {
        String title = metadata.get("dc:title");
        if (title != null)
            System.out.println("Название трека: " + title);
        else
            System.out.println("Название трека отсутствует в метаданных");
    }
}
