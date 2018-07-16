import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	private static final String ACCESS_TOKEN = "IWsEa8AKiAsAAAAAAAAAbxGz4NivNyjgkiP0x8Rr8TAXs0VltTdBZFOypOXSmHuV";

	public static void main(String[] args) throws IOException, DbxException {
		DbxRequestConfig config = DbxRequestConfig.newBuilder("downloadfromStorage").withUserLocale("en_us").build();
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
		URL url = new URL("https://omnibuser.s3.amazonaws.com/documents/101297/1.epub");
		try(InputStream is = url.openStream()) {
			FileMetadata metadata = client.files().uploadBuilder("/1.epub")
					.uploadAndFinish(is);
		}
	}
}
