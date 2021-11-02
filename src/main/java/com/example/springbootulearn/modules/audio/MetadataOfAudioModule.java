package com.example.springbootulearn.modules.audio;

import com.example.springbootulearn.FileUtil;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

@Component
public class MetadataOfAudioModule extends AbstractAudioModule{
    @Override
    public String describeFunction() {
        return "Вывод метаданных";
    }

    @Override
    public void function(File file) {
        try (InputStream input = new FileInputStream(file)) {
            Parser parser = new Mp3Parser();

            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            ParseContext parseCtx = new ParseContext();
            parser.getSupportedTypes(parseCtx);

            parser.parse(input, handler, metadata, parseCtx);

            printFullInformation(metadata);

        } catch (IOException | SAXException | TikaException e) {
            System.out.println(e.getMessage());
        }
    }
    private void printFullInformation(Metadata metadata) {
        String[] metadataNames = metadata.names();
        System.out.println("Метаданные трека:");
        System.out.println("----------------------------");
        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}
