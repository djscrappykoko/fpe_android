public class DatabaseHelper {
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        mDatabase = context.openOrCreateDatabase("mydatabase", Context.MODE_PRIVATE, null);
    }

    public void createTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, email TEXT)";
        mDatabase.execSQL(createTableQuery);
    }

    public void addUser(String name, String email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        mDatabase.insert("users", null, contentValues);
    }

    public List getAllUsers() {
        String selectQuery = "SELECT * FROM users";
        Cursor cursor = mDatabase.rawQuery(selectQuery, null);
        List users = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String[] user = new String[] {name, email};
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public void deleteUser(int id) {
        String deleteQuery = "DELETE FROM users WHERE id = " + id;
        mDatabase.execSQL(deleteQuery);
    }
}

To use this database helper class in an activity, we can create an instance of the class and call its methods as needed. For example:

  public class MyActivity extends AppCompatActivity {
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseHelper = new DatabaseHelper(this);
        mDatabaseHelper.createTable();
    }

    // Add a new user
    public void addUserButtonClick(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        EditText emailEditText = (EditText) findViewById(R.id.email_edit_text);
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        mDatabaseHelper.addUser(name, email);
    }

    // Retrieve all users
    public void retrieveAllUsersButtonClick(View view) {
        List users = mDatabaseHelper.getAllUsers();
        // Display the users in a ListView or other UI element
    }

    // Delete a user
    public void deleteUserButtonClick(View view) {
        int id = Integer.parseInt( findViewById(R.id.id_edit_text).getText().toString());
        mDatabaseHelper.deleteUser(id);
    }
}
