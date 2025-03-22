import java.util.Comparator;

public class AuthorName implements Comparator<BookDetails> {

    @Override
    public int compare(BookDetails b1, BookDetails b2) {
    	// TODO Auto-generated method stub
        return b1.getAuthorName().compareToIgnoreCase((b2.getAuthorName()));
    }

}
