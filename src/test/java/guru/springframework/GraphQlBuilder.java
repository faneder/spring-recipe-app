package guru.springframework;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class GraphQlBuilder {

    private final String query;

    public String builder(Object... args) {
        return String.format(query, args);
    }

    public String query() {
        return String.format("query { %s }", this.query);
    }
}