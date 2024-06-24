package org.example.metabox.movie;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies/list")
    public String list(HttpServletRequest request) {
        // 상영 중 또는 개봉 예정인 영화 정보를 가져와 movies 리스트에 저장합니다.
        List<MovieResponse.UserMovieChartDTO> movies = movieService.getMovieChart();

        // HttpServletRequest에 movies를 추가합니다.
        request.setAttribute("models", movies);

        // "movie/list" 뷰를 반환하여 영화 리스트 페이지를 표시합니다.
        return "movie/list";
    }

    @GetMapping("/movies/detail/{movieId}")
    public String detail(@PathVariable("movieId") int movieId, HttpServletRequest request) {

        MovieResponse.UserMovieDetailDTO movieDetail = movieService.getMovieDetail(movieId);

        // HttpServletRequest에 movie를 추가합니다.
        request.setAttribute("model", movieDetail);
        return "movie/detail";
    }
}
