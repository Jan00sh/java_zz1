import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Script{

	public static String getFile(String filePath) throws FileNotFoundException{
		File userFile = new File(filePath);
		Scanner fileScan = new Scanner(userFile);
		fileScan.useDelimiter("\\Z");
		return fileScan.next();
	}

	public static boolean checkForKeyword(String base, String keyword){
		if(base.equals(keyword))
			return true;
		else return false;
	}

	public static void main(String[] args) throws Exception {
		System.out.print("File path: ");
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		String filePath = userInput.nextLine();
		String fileScan = getFile(filePath);
		
		System.out.print("Searched keyword: ");
		String searchedKeyword = userInput.nextLine();
		System.out.println(searchedKeyword);
		
		fileScan = fileScan.replace("\n", "");
		fileScan = fileScan.toLowerCase();
		
		//histogram
		int[] instancesArray = new int[26];
		for(char letter : fileScan.toCharArray()){
			int letterToInt = letter;
			if(letterToInt < 97 || letterToInt > 122)
				continue;
			instancesArray[letterToInt - 97]++;
		}
		int j = 97;
		for(int number : instancesArray){
			char character = (char)j;
			System.out.print(character + ": " + number + " ");
			j++;
		}

		//wzorzec w tekscie
		int occurences = 0;

		for(int x = 0; x < fileScan.length(); x++){
			if(fileScan.toCharArray()[x] == searchedKeyword.toCharArray()[0]){
				if(checkForKeyword(fileScan.substring(x,x+searchedKeyword.length()), searchedKeyword))
					occurences++;
				else continue;
			}
		}
		System.out.println("\nW pliku \"" + filePath + "\" slowo " + searchedKeyword + " wystepuje " + occurences + " razy.");
	}
	
}
