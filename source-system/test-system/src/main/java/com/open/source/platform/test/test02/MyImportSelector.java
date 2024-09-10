package com.open.source.platform.test.test02;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/9
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> names = SpringFactoriesLoader.loadFactoryNames(MyImportSelector.class, null);

        return names.toArray(new String[0]);
//        return new String[]{AutoConfiguration1.class.getName(), AutoConfiguration2.class.getName()};
    }

}
