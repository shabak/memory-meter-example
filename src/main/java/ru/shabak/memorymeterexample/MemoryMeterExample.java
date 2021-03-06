package ru.shabak.memorymeterexample;

import java.util.ArrayList;
import java.util.List;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.base.Splitter;
import org.github.jamm.MemoryMeter;

/**
 * @author Nikolay Shabak (nikolay)
 * @since 15/08/16
 */
public class MemoryMeterExample {

    // https://github.com/jbellis/jamm
    // -javaagent:/Users/nikolay/.m2/repository/com/github/jbellis/jamm/0.3.1/jamm-0.3.1.jar should be passed to VM options
    public static void main(String[] args) {

        MemoryMeter meter = new MemoryMeter();

        String s1 = "U";
        String s2 = "US";
        String s3 = "USD";
        String s4 = "USDUSDUSDUSDUSDUSDUSDUSDUSDUSDUSDUSDUSD";
        List<String> list = Splitter.on(",").splitToList("RU,BY,KZ");
        List<String> list2 = Splitter.on(",").splitToList("RU,BY,KZ,RU,BY,KZ");
        List<String> list3 = Splitter.on(",").splitToList("RU,BY,KZ,RU,BY,KZ,RU,BY,KZ,BY,KZ,RU,BY,KZ,RU,BY,KZ,BY,KZ,RU,BY,KZ,RU,BY,KZ");

        List<RelatedEntity> relatedEntities = new ArrayList<RelatedEntity>();
        relatedEntities.add(new RelatedEntity(1, "name"));
        relatedEntities.add(new RelatedEntity(2, "namenamename"));
        relatedEntities.add(new RelatedEntity(3, "name"));
        relatedEntities.add(new RelatedEntity(4, "name"));
        Entity entity = new Entity(1,"name","description", list3, relatedEntities);

        System.out.println("-= Ram Usage Estimator =-");
        System.out.println(RamUsageEstimator.humanSizeOf(s1));
        System.out.println(RamUsageEstimator.humanSizeOf(s2));
        System.out.println(RamUsageEstimator.humanSizeOf(s3));
        System.out.println(RamUsageEstimator.humanSizeOf(s4));
        System.out.println(RamUsageEstimator.humanSizeOf(list));
        System.out.println(RamUsageEstimator.humanSizeOf(list2));
        System.out.println(RamUsageEstimator.humanSizeOf(list3));
        System.out.println(RamUsageEstimator.humanSizeOf(entity));

        System.out.println("-= Memory Meter =-");
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(s1)));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(s2)));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(s3)));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(s4)));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(list)));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(list2)));
        long measure = meter.measureDeep(list3);
        System.out.println(RamUsageEstimator.humanReadableUnits(measure));
        System.out.println(RamUsageEstimator.humanReadableUnits(meter.measureDeep(entity)));

    }
}
