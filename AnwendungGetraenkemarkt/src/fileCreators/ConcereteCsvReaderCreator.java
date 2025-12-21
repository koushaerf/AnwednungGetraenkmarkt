package fileCreators;

public class ConcereteCsvReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() {
		
		return new ConcreteCsvReaderProduct();
	}

}
