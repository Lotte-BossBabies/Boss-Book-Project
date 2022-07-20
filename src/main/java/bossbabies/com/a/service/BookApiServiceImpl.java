package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookApiDaoImpl;

import bossbabies.com.a.dto.BookDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]도서 api 파싱
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       김혜연         신규생성
 * -----------------------------------------------------------
 */
@Service
@PropertySource("classpath:/properties/api.properties")
public class BookApiServiceImpl implements BookApiService{

    @Autowired
    BookApiDaoImpl dao;

    @Value("${api.interpark_api_key}")
    String apikey;

    public boolean insertData() throws IOException, ParseException {

        //book 데이터 접근 후 데이터가 없으면 데이터 넣어주기
        if (dao.findAll().size() == 0) {

            int[] booknum = {101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 129};

            List<BookDto> books = new ArrayList<>();
            for (int b : booknum) {
                StringBuffer result = new StringBuffer();

                //기본 url
                String categoryId = b + "";
                System.out.println("categoryId = " + categoryId);
                StringBuilder urlBuilder = new StringBuilder("https://book.interpark.com/api/bestSeller.api");
                urlBuilder.append("?" + URLEncoder.encode("key", "UTF-8") + "=" + apikey);
                urlBuilder.append("&" + URLEncoder.encode("categoryId", "UTF-8") + "=" + categoryId); //카테고리 아이디
                urlBuilder.append("&" + URLEncoder.encode("output", "UTF-8") + "=json");

                URL url = new URL(urlBuilder.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader rd;
                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                } else {
                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }

                String line;

                while ((line = rd.readLine()) != null) {
                    result.append(line + "\n");
                }

                rd.close();
                conn.disconnect();

                //json 파싱
                JSONObject jObject = new JSONObject(result + "");
                JSONArray items = jObject.getJSONArray("item");

                for (int i = 0; i < 10; i++) {
                    JSONObject book = items.getJSONObject(i);

                    //isbn
                    String isbn = book.getString("isbn");
                    //title
                    String title = book.getString("title");
                    //author
                    String author = book.getString("author");
                    //price
                    int price = book.getInt("priceStandard");
                    //description
                    String description = book.getString("description");
                    //image_url
                    String imageUrl = book.getString("coverLargeUrl");
                    //category
                    String strCategory = book.getString("categoryName");
                    String category = strCategory.substring(strCategory.lastIndexOf(">") + 1);
                    //pubdate
                    String strPubDate = book.getString("pubDate");
                    Date date = new SimpleDateFormat("yyyyMMdd").parse(strPubDate);
                    Instant pubDate = date.toInstant();

                    //publisher
                    String publisher = book.getString("publisher");

                    BookDto dto = new BookDto(isbn, title, author, price, description, imageUrl, category, pubDate, publisher);
                    books.add(dto);

                }
            }

            return dao.insertData(books);
        }

        return true;
    }
}
