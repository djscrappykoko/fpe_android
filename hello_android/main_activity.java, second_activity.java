// MainActivity.java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "MainActivity: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "MainActivity: onDestroy");
    }
}
