
package com.interai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Interview {

    @Id
    private String id;

    private String question;

    private String answer;

    private String feedback;
}
