package com.example.PetnityServer.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class PostDTO {
    public static class Request {
        @Getter
        @AllArgsConstructor
        @Builder
        public static class CreateAndUpdate {
            private String password;
            private String title;
            private String message;
            private Short dogAge;
            private String dogName;
            private String location;
        }


        public static class Delete {
            @Getter
            @AllArgsConstructor
            @Builder
            public static class ById {
                private Long id;
            }
        }
    }
    public static class Response {
        @Getter
        @AllArgsConstructor
        @Builder
        public static class Read {
            private Long id;
            private String title;
            private String message;
            private Short dogAge;
            private String dogName;
            private String location;
        }
    }
}
