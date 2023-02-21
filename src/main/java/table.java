import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class table {
    private WebElement tableElement;
    private WebDriver driver;

    public table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }
    public List<WebElement> getRows(){
        List<WebElement> rows = tableElement.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
        rows.remove(0);
        return rows;
    }
    public List<WebElement> getHeadings(){
        WebElement row = tableElement.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]"));
        List<WebElement> headingsColumns = row.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
        return headingsColumns;
    }
    public List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row: rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }
    public List<Map<String, WebElement>> getRowsWithColumnsNeednings(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> RowsWithColumnsNeednings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingsColumns = getHeadings();
        for (List<WebElement> row: rowsWithColumns){
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i =0; i < headingsColumns.size();i++){
                String heading = headingsColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
        }
            RowsWithColumnsNeednings.add(rowByHeadings);
    }
        return RowsWithColumnsNeednings;
    }
    public String getValueFromCell (int rowNumber, int rowColumn){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber-1).get(rowColumn-1);
        return cell.getText();
    }
    public String getValueFromCell (int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsNeednings = getRowsWithColumnsNeednings();
        return rowsWithColumnsNeednings.get(rowNumber-1).get(columnName).getText();
    }
}
