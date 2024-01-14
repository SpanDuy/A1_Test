package com.example.test3.parser;

import com.example.test3.entity.Login;
import com.example.test3.entity.Posting;
import com.example.test3.parser.parserImpl.LoginsParser;
import com.example.test3.parser.parserImpl.PostingParser;
import org.aspectj.weaver.Position;

public class ParserFactory {
    public static Parser getParser(Object object) {
        if (Login.class.equals(object.getClass())) {
            return new LoginsParser();
        } else if (Posting.class.equals(object.getClass())) {
            return new PostingParser();
        } else {
            return null;
        }
    }

}
