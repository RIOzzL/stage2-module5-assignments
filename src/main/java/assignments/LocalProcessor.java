package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String string : stringArrayList) {
            System.out.println(string.hashCode());
        }
//        for (int i = 0; i < period; i++) {
//            System.out.println(stringArrayList.get(i).hashCode());
//        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < stringArrayList.size(); i++) {
//            sb.append(stringList.get(i)).append(' ');
//          //  processorName += stringList.get(i) + ' ';
//        }
        for (String string : stringArrayList) {
            sb.append(string).append(' ');
        }
        processorName = sb.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (informationScanner.hasNext()) {
            sb.append(informationScanner.nextLine());
            // processorVersion += informationScanner.nextLine();
        }
        processorVersion = sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalProcessor that = (LocalProcessor) o;

        if (processorName != null ? !processorName.equals(that.processorName) : that.processorName != null)
            return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (processorVersion != null ? !processorVersion.equals(that.processorVersion) : that.processorVersion != null)
            return false;
        if (valueOfCheap != null ? !valueOfCheap.equals(that.valueOfCheap) : that.valueOfCheap != null) return false;
        return informationScanner != null ? informationScanner.equals(that.informationScanner) : that.informationScanner == null;
    }

    @Override
    public int hashCode() {
        int result = processorName != null ? processorName.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (processorVersion != null ? processorVersion.hashCode() : 0);
        result = 31 * result + (valueOfCheap != null ? valueOfCheap.hashCode() : 0);
        result = 31 * result + (informationScanner != null ? informationScanner.hashCode() : 0);
        return result;
    }
}
