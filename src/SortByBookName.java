import java.util.Comparator;

public class SortByBookName implements Comparator<BookDetails> {

	@Override
	public int compare(BookDetails b1, BookDetails b2) {
		// TODO Auto-generated method stub
		return b1.getBookName().compareToIgnoreCase(b2.getBookName());
	}

}
