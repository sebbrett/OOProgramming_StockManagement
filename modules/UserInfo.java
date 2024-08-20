package modules;

public class UserInfo {
    private String fullName;
    private String userID;

    // Constructor
    public UserInfo() {
        fullName = "NA";
        userID = "guest";
    }
    
    public UserInfo(String fullName, String userID) {
        this.fullName = fullName;
        this.userID = userID;
    }

    // Method to generate a user ID
    public static String generateUserID(String fullName) {
        if (hasSpaces(fullName)) {
            String[] parts = fullName.split(" "); 
            return Character.toString(parts[0].charAt(0)) + parts[parts.length-1];
        } else 
            return "guest";
    }
    
	// Method to check if the name contains spaces
    public static boolean hasSpaces(String fullName) {
        return fullName.contains(" ");
    }
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserID() {
		return userID;
	}
}
