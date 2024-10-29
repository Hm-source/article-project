package com.example.articleproject.dto;

import com.example.articleproject.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    // 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드이다.
    // 추후 블로그 글을 추가할 때 저장할 엔티티로 변환한는 용도로 사용.
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
