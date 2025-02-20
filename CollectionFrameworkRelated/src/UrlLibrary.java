import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This class is used in ImplementingIterable
public class UrlLibrary implements Iterable<String> {
    private List<String> urls = new LinkedList<>();

    // Inner class
    private class UrlIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < urls.size();
        }

        @Override
        public String next() {
            StringBuilder sb = new StringBuilder();

            try{
                URL url = new URL(urls.get(index));

                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                String line = null;

                while((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }

                br.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
            index++;

            return sb.toString();
        }

        @Override
        public void remove() {
            urls.remove(index);
        }
    }

    public UrlLibrary(){
        urls.add("https://www.facebook.com");
        urls.add("https://www.google.com");
        urls.add("https://www.amazon.in/");
    }

    @Override
    public Iterator<String> iterator() {
        return new UrlIterator();
    }

//    @Override
//    public Iterator<String> iterator() {
//        System.out.println("Using Iterator: " + urls.iterator()); // List address
//        return urls.iterator();
//    }

}