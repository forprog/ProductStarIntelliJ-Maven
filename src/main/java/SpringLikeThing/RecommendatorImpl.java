package SpringLikeThing;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator created");
    }

    @Override
    public void recommend() {
        System.out.println("drink "+alcohol);
    }
}
