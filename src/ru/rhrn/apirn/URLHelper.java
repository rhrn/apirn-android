package ru.rhrn.apirn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

class URLHelper {

  private int code;
  private String url;
  private String query;
  private String data;

  public void url(String url) {
    this.url = url;
  }

  public void query(String query) {
    this.url = this.url + "?" + query;
  }

  public void data(String data) {
    this.data = data; 
  }

  public void code(int code) {
    this.code = code;
  }

  public String url() {
    return url;
  }

  public String data() {
    return data;
  }

  public int code() {
    return code;
  }

  private HttpURLConnection connect() throws IOException, MalformedURLException {

    URL url = new URL(this.url());
    return (HttpURLConnection) url.openConnection();
  }

  private void write(HttpURLConnection connection) throws IOException {

    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
    out.write(this.data());
    out.close();
  }

  private String response(HttpURLConnection connection) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

    code(connection.getResponseCode());

    String line;
    String response = "";
    while((line = in.readLine()) != null) {
        response += line;
    }

    in.close();

    return response;
  }

  public String get() throws Exception {
    HttpURLConnection uc = connect();
    return response(uc);
  }

  public String post() throws Exception {

    HttpURLConnection uc = connect();

    uc.setDoOutput(true);
    uc.setRequestMethod("POST");

    write(uc);

    return response(uc);
  }

  public String put() throws Exception {

    HttpURLConnection uc = connect();

    uc.setDoOutput(true);
    uc.setRequestMethod("PUT");

    write(uc);

    return response(uc);
  }

  public String delete() throws Exception {

    HttpURLConnection uc = connect();

    uc.setDoOutput(true);
    uc.setRequestMethod("DELETE");

    return response(uc);
  }

/*
  public static void main (String[] args) {

      URLHelper helper = new URLHelper();

      helper.url("http://devmultiship.loc/v1/tests/rest");
      helper.query("token=123213");
      helper.data("login=cefef&password=vrgfwregreg");

      try {
        System.out.println(helper.get());
        System.out.println(helper.post());
        System.out.println(helper.put());
        System.out.println(helper.delete());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

  }
*/


}
