public class Search {
    @JsonProperty
    private String city;
}
public class SearchResult {
    @JsonProperty
    private String city;

    @JsonProperty
    private String kind;

    @JsonProperty
    private String title;
}
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {

    private List<SearchResult> searchResults;

    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @POST
    public List<SearchResult> getResults(Search search) {
        return searchResults.stream()
                .filter(r -> r.getCity().equalsIgnoreCase(search.getCity()))
                .collect(Collectors.toList());
    }
}
environment.jersey().register(new SearchResource(searchResults));
