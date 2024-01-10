package jp.ac.ohara;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class AddressBookManager {
  private static final String CSV_FILE = "address.json";

  private List<AddressBook> addressesBooks = new ArrayList<AddressBook>();

  private Gson gson = new Gson();
  private Type listType = new TypeToken<ArrayList<AddressBook>>(){}.getType();

  public AddressBookManager() {
    try (FileReader reader = new FileReader(AddressBookManager.CSV_FILE)) {
      this.addressesBooks = gson.fromJson(reader, listType);
    } catch (FileNotFoundException e) {
      // ファイルがない場合は何もしない
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void list() {
    System.out.println("一覧表示 --------------------");
    for (AddressBook address : this.addressesBooks) {
      System.out.println(address.toString());
    }
    System.out.println("----------------------------");
  }

  public void detail(int index) {
    System.out.println("詳細表示 --------------------");
    System.out.println(this.addressesBooks.get(index-1).detail());
    System.out.println("----------------------------");
  }

  public void add(AddressBook address) {
    this.addressesBooks.add(address);
  }

  public void delete(int index) {
    this.addressesBooks.remove(index-1);
  }

  public void save() {
    try (FileWriter writer = new FileWriter(AddressBookManager.CSV_FILE)) {
      // 他のデータを追加する場合は、以下のように行を追加します
      gson.toJson(this.addressesBooks, writer);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
