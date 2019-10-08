package miscellaneous;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.RepaintManager;

import com.exercise.search.replace.api.ProcessSearchReplace;
import com.exercise.search.replace.model.Model;

/**
 * @Description: Reads file and Searches for a word to be Replaced and then
 *               Replaces the word with the New Word.
 *
 */
public class ReadFileInMemory implements ProcessSearchReplace {

	/**
	 * @Description: Takes Model POJO as parameter and then performs replace All.
	 */
	@Override
	public void readFileSource(Model model) {
		try {

			Path source = Paths.get(model.getSourceFile());

			Path destination = Paths.get(model.getDestinationFile());
			Stream<String> lines = Files.lines(source);

			List<String> replaced = lines.map(line -> line.replaceAll(model.getSearchWord(), model.getReplaceWord()))
					.collect(Collectors.toList());
			
			Files.write(destination, replaced);

			System.out.println("Find and Replace Completed ! " + model.getSearchWord() + " is replaced with "
					+ model.getReplaceWord() + ".");

			lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}