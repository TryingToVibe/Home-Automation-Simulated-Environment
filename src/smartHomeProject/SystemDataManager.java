package smartHomeProject;

import java.io.*;

public class SystemDataManager {
	private static final String DATA_FOLDER = "systemData";

	private static File getSystemFile(String admin) {
		File folder = new File(DATA_FOLDER);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		return new File(folder, admin + ".dat");
	}

	public static void save(String admin, SystemData data) throws IOException {
		try (ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream(getSystemFile(admin)))) {
			out.writeObject(data);
		}
	}

	public static SystemData load(String admin) throws IOException, ClassNotFoundException {
		File file = getSystemFile(admin);

		if(!file.exists()) {
			return new SystemData();
		}

		try (ObjectInputStream in =
				new ObjectInputStream(new FileInputStream(file))) {
			return (SystemData) in.readObject();
		}
	}


}
