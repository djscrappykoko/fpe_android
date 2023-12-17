// FetchDataAsyncTask.java
public class FetchDataAsyncTask extends AsyncTask {
    
    @Override
    protected String doInBackground(Void... voids) {
        // Make network request and fetch data from REST API
        // Return fetched data as string
        return fetchedData;
    }

   @Override
   protected void onPostExecute(String result) {
       // Update UI with fetched data (e.g., populate RecyclerView)
   }
}
