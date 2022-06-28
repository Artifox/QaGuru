package lesson9_files.homework;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseZipHomeWorkTests {
    ClassLoader classLoader = ParseZipHomeWorkTests.class.getClassLoader();

    @Test
    public void readPDFFromZip() throws IOException {
        ZipFile zipFile = new ZipFile(Objects.requireNonNull(classLoader.getResource("zip/test-zip.zip")).getFile());
        ZipEntry pdfEntry = zipFile.getEntry("pdf-test.pdf");
        InputStream inputStream = zipFile.getInputStream(pdfEntry);
        PDF pdf = new PDF(inputStream);
        assertThat(pdf.text).contains("PDF Test");
    }

    @Test
    public void readXLSXFromZip() throws IOException {
        ZipFile zipFile = new ZipFile(Objects.requireNonNull(classLoader.getResource("zip/test-zip.zip")).getFile());
        ZipEntry xlsxEntry = zipFile.getEntry("xlsx-test.xlsx");
        InputStream inputStream = zipFile.getInputStream(xlsxEntry);
        XLS xlsx = new XLS(inputStream);
        assertThat(xlsx.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).contains("First Name");
    }

    @Test
    public void readCSVFromZip() throws Exception {
        ZipFile zipFile = new ZipFile(Objects.requireNonNull(classLoader.getResource("zip/test-zip.zip")).getFile());
        ZipEntry csvEntry = zipFile.getEntry("csv-test.csv");
        InputStream inputStream = zipFile.getInputStream(csvEntry);
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
        List<String[]> csv = csvReader.readAll();
        assertThat(csv.get(0)[1]).isEqualTo("Eldon Base for stackable storage shelf, platinum");
    }
}
