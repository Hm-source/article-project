package com.example.articleproject.service;

import com.example.articleproject.domain.Article;
import com.example.articleproject.repository.BlogRepository;
import com.example.articleproject.dto.AddArticleRequest;
import com.example.articleproject.dto.UpdateArticleRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
// 빈을 생성자로 생성하는 롬복에서 지원하는 애너테이션이다. final이나 @NotNull이 붙은 필드로 생성자를 만들어준다.
@Service
// 서비스 에너테이선은 해당 클래스를 빈으로 스프링 컨테이너에 등록
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        // save 메서드 -> insert
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 조회(단일)
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
    // 블로그 글 조회(단일)
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    // 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
