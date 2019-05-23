import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    @Test
    public void firs() {
        Pattern pattern = Pattern.compile("a"); // ищет все a в тексте
        Matcher matcher = pattern.matcher("Jack is a boy");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void second() {
        Pattern pattern = Pattern.compile("cat"); // ищет все cat в тексте
        Matcher matcher = pattern.matcher("About cats and dogs");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void theard() {
//        Pattern pattern = Pattern.compile("1\\+1=2");
//        \Qtext\E - считается как дословное
        Pattern patternNew = Pattern.compile("\\Q1+1=2\\E"); // равно тому же, что и в переменной pattern
        Matcher matcher = patternNew.matcher("1+1=2");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fourth() {
        Pattern pattern = Pattern.compile("[a-z]]"); // ищет любую букву, с символом ] после неё
        Matcher matcher = pattern.matcher("He123 c]aptured321 a catfish 123for his cat");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fifth() {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z_;$%:-\\\\?]"); // \\\\ - 3 слеша экранируют 1 слеш
        Matcher matcher = pattern.matcher("123456789abcduvwxyz_\\$-%:;$%:-?");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void sixth() {
        Pattern pattern = Pattern.compile("\\Q[-]\\E"); // дословно ищет что указано между \\Q и \\E
        Matcher matcher = pattern.matcher("[-]");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void seventh() {
        Pattern pattern = Pattern.compile("gr[ae]y"); // может принять слово имеющее как a так и e
        Matcher matcher = pattern.matcher("gray");
        Matcher matcherNew = pattern.matcher("grey");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
        while (matcherNew.find()) {
            System.out.println(String.format("%s %s", matcherNew.start(), matcherNew.group()));
        }
    }

    @Test
    public void eighth() {
        Pattern pattern = Pattern.compile("[^a-h]"); // игнорирует все буквы от a до h
        Matcher matcher = pattern.matcher("abcdefghijklmn");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void ningth() {
        Pattern pattern = Pattern.compile("\\d"); // только цифры
        Matcher matcher = pattern.matcher("asdkjb124asd53");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void ningth2() {
        Pattern pattern = Pattern.compile("\\D"); // всё кроме цифр
        Matcher matcher = pattern.matcher("asdkjb124asd53*/");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void tenth() {
        Pattern pattern = Pattern.compile("\\w"); // любую букву или цифру, но без спецсимволов
        Matcher matcher = pattern.matcher("asdkjb 124asd*/53");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void tenth2() {
        Pattern pattern = Pattern.compile("\\W"); //только спецсимволы
        Matcher matcher = pattern.matcher("asdkjb124asd*/53");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void eleventh() {
        Pattern pattern = Pattern.compile("\\s"); // только пробелы
        Matcher matcher = pattern.matcher("asdkjb 124asd53");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void eleventh2() {
        Pattern pattern = Pattern.compile("\\S"); // всё кроме пробелов
        Matcher matcher = pattern.matcher("asdkjb 124asd53");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void twelve() {
        Pattern pattern = Pattern.compile("[\\s\\d]"); // ищет и пробелы и цифры
        Matcher matcher = pattern.matcher("asd 14 ");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void thirteen() {
        Pattern pattern = Pattern.compile("\\s\\d"); // ищет пробелы после которых идут цифры
        Matcher matcher = pattern.matcher("asd 14 ");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fourteen() {
//        mm/dd/yy
        Pattern pattern = Pattern.compile("\\d\\d.\\d\\d.\\d\\d"); // точка заменяет любой символ во входящей строке, в данном случае точка заменяет символ /
        Matcher matcher = pattern.matcher("02/12/03");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fourteen1() {
//        mm/dd/yy
        Pattern pattern = Pattern.compile("\\d\\d[- /\\\\:.]\\d\\d[- /\\\\:.]\\d\\d"); // точка заменяет любой символ во входящей строке, в данном случае точка заменяет символы: тире, пробел, слеш, обратный слеш, двоеточие, точка
        Matcher matcher = pattern.matcher("02/12/03");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fifteen() {
        Pattern pattern = Pattern.compile("\".*\""); // символ * указывает, что количество символов динамическое, и сам экспрешен будет искать всё что заключено в ""
        Matcher matcher = pattern.matcher("Put a \"string\" between double quotes");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fifteen1() {
        Pattern pattern = Pattern.compile("\".*\""); // так регулярный экспрешен найдёт всё что указано между самыми первыми " и самыми последними " (greedy expression или так называемый жадный экспрешен)
        Matcher matcher = pattern.matcher("There are \"string one\" and \"string two\" between double quotes");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fifteen2() {
        Pattern pattern = Pattern.compile("\".*?\""); // так регулярный экспрешен найдёт поочерёдно первую строку между "" за тем вторую строку между "" (Reluctant или lazy экспрешен)
        Matcher matcher = pattern.matcher("There are \"string one\" and \"string two\" between double quotes");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void fifteen3() {
        Pattern pattern = Pattern.compile("\"[^\"\r\n]*\""); // работает аналогично fifteen2()
        Matcher matcher = pattern.matcher("There are \"string one\" and \"string two\" between double quotes");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void sixteen() {
//        символ ^ = является знаком начала строки, когда находится не в [] скобках
//        символ $ = является знаком конца строки
        Pattern pattern = Pattern.compile("^a"); // ^ = начало строки, экспрешен ищет строку (не слова), которая начинаются с буквы a
//        Pattern pattern = Pattern.compile("\\Aa"); // работает аналогично ^a
//        Pattern pattern = Pattern.compile("^ab"); // ^ = начало строки, экспрешен ищет строку (не слова), которая начинаются с буквы a
//        Pattern pattern = Pattern.compile("^b"); // экспрешен ищет строку, которая начинается с буквы b
//        Pattern pattern = Pattern.compile("c$"); // экспрешен ищет строку, которая заканчивается на букву c
//        Pattern pattern = Pattern.compile("c\\Z"); // работает аналогично c$
//        Pattern pattern = Pattern.compile("b$"); // экспрешен ищет строку, которая заканчивается на букву b
        Matcher matcher = pattern.matcher("abc");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void seventeen() {
//        Pattern pattern = Pattern.compile("\\d+"); // находит все числа в строке
        Pattern pattern = Pattern.compile("^\\d+$"); // определяет, что в строке от начала и до конца только цифры
//        Matcher matcher = pattern.matcher("ab4c 1243 6a42sd6v");
        Matcher matcher = pattern.matcher("1243");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void eighteen() {
//        Pattern pattern = Pattern.compile("ne$"); // в одной строке находит строку, что заканчиваются на символы ne
        Pattern pattern = Pattern.compile("ne$", Pattern.MULTILINE); // из нескольких строк находит строки, что заканчиваются на символы ne
//        Pattern pattern = Pattern.compile("ne\\z", Pattern.MULTILINE); // в слове line\n знак \z учитывает символы "\n", а $ не учитывает "\n"
        Matcher matcher = pattern.matcher("first line\nsecond sine");
        while (matcher.find()) {
            System.out.println(String.format("%s %s", matcher.start(), matcher.group()));
        }
    }

    @Test
    public void nineteen() {
        Pattern pattern = Pattern.compile("cat|dog"); // ищет или cat или dog
        Matcher matcher = pattern.matcher("I like my dog!");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end(), matcher.group()));
        }
    }

    @Test
    public void twenty() {
//      знак | является знаком "или"
        Pattern pattern = Pattern.compile("Get|GetValue|Set|SetValue"); // находит первое совпадение среди вхождений, а последующие игнорирует
//        Pattern pattern = Pattern.compile("GetValue|Get|SetValue|Set"); //
//        Pattern pattern = Pattern.compile("Get(Value)|Set(Value)"); //
//        Pattern pattern = Pattern.compile("\\b(Get|GetValue|Set|SetValue)\\b"); //
//        Pattern pattern = Pattern.compile("\\b(Get(Value)?|Set(Value)?)\\b"); //
//        Pattern pattern = Pattern.compile("\b(Get\Set)(Value)?\b"); //
        Matcher matcher = pattern.matcher("SetValue");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end(), matcher.group()));
        }
    }

    @Test
    public void twentyOne() {
//        знак ? ставится после указаного символа (или группы символов) и указывает на опциональность этого символа (или группы символов)
        Pattern pattern = Pattern.compile("colou?r"); //
        Matcher matcher = pattern.matcher("color colour");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyTwo() {
        Pattern pattern = Pattern.compile("Nov(ember)?"); // символы, что находятся в ()? являются опциональными, экспрешен найдёт и Nov и November
        // тоесть он определяет вхождение (ember) может быть 0 или 1 раз
        Matcher matcher = pattern.matcher("Noveber Nov");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyTwo1() {
        //        ? символ является Greedy, изменить его на не жадный можно добавив ещё один знак ?
        Pattern pattern = Pattern.compile("Nov(ember)??"); // символы, что находятся в ()? являются опциональными, экспрешен найдёт Nov (ember игнорируется) в November и просто Nov
        Matcher matcher = pattern.matcher("Noveber Nov");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyTwo2() {
        Pattern pattern = Pattern.compile("Nov(ember)? 23(rd)?"); // символы, что находятся в ()? являются опциональными, экспрешен найдёт и Nov и November
        Matcher matcher = pattern.matcher("November 23 November 23rd Nov 23 Nov 23rd");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyThree() {
        // * - количество символов от 0 до ...
        Pattern pattern = Pattern.compile("<[A-Za-z][A-Za-z0-9]*"); // ищет всё, начитая со знака < и после него должна идти буква, а после неё могут быть буквы или цыфры, а может и нет
        Matcher matcher = pattern.matcher("<h1>");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyThree1() {
        // + - количество символов от 1 до ...
        Pattern pattern = Pattern.compile("<[A-Za-z][A-Za-z0-9]+"); // ищет всё, начитая со знака < и после него должна идти буква, а после неё должны быть буквы или цифры
        Matcher matcher = pattern.matcher("<a>"); // не найдёт ничего
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyFour() {
        Pattern pattern = Pattern.compile("\\b[1-9][0-9]{3}\\b"); // ищет цифры, в которых 1-я цифра от 1 до 9, 2-я цифра от 0 до 9 и этих цифр должно быть 3
        Matcher matcher = pattern.matcher("1000 9999");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyFour1() {
        Pattern pattern = Pattern.compile("\\b[1-9][0-9]{2,5}\\b"); // ищет цифры, в которых 1-я цифра от 1 до 9, 2-я цифра от 0 до 9 и этих цифр должно быть от 2 до 5
        Matcher matcher = pattern.matcher("100 99999 555555");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyFive() {
        Pattern pattern = Pattern.compile("<.+>"); // + является Greedy (жадным) и находит всё, что находится между самой первой < до самой последней >
        Matcher matcher = pattern.matcher("This is a <EM>first</EM> test");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyFive1() {
        Pattern pattern = Pattern.compile("<.+?>"); // + стал Reluctant и находит каждый набор символов отдельно
        Matcher matcher = pattern.matcher("This is a <EM>first</EM> test");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyFive2() {
        Pattern pattern = Pattern.compile("<[^>]+>"); // ищет кавычки с любы набором символов между кавычками, в котором символы не вяляются символом >
        Matcher matcher = pattern.matcher("This is a <EM>first</EM> test");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentySix() {
//        (group) - является группой (оно же backreference), к которой можно обращаться по номеру перед которым стоит \\ , где номер - порядок по которому групппы написаны в регулярном выражении
//        когда в группе после открывающейся скобки стоят символы ?: - значит этот backreference не нужно запоминать и порядковый номер ему назначен не будет
        Pattern pattern = Pattern.compile("Set(?:Value)?");
        Matcher matcher = pattern.matcher("Set SetValue");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentySeven() {
        Pattern pattern = Pattern.compile("EditPad (Lite|Pro) edition"); // находит текст до () + группу + после группы
        Matcher matcher = pattern.matcher("EditPad Pro edition");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentySeven1() {
//        в java, если использовать метод не Pattern.compile, то обращаться к группе нужно через знак $
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$1 version"));
    }

    @Test
    public void twentySeven2() {
//        $0 - значит обращение ко всему регулярному выражению, а не только к одной группе
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$0 version"));
    }

    @Test
    public void twentyEight() {
        Pattern pattern = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>"); // найдёт тег, его тело и закрывающий тег
        Matcher matcher = pattern.matcher("This is a <EM>first</EM> test This is a <EM>second</EM> test");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyEight1() {
//        нельзя обратится к группе изнутри самой группы
        Pattern pattern = Pattern.compile("([a-c])x\\1x\\1"); // то что нашло в группе, в дальнейшем будет подставляться при обращении к ней
        Matcher matcher = pattern.matcher("axaxa"); // ecuals [a-c]xaxa - потому-что в месте указания группы нашло a, и в дальнейшем при обращении к группе всегда будет a
//        Matcher matcher = pattern.matcher("axbxa"); не найдёт
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyEight2() {
        Pattern pattern = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>"); // вместо \\1 подставится то, что было первым найдено 1-й группой, а это <B>
        Matcher matcher = pattern.matcher("Testing <B><I>bold italic</I></B> text");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyNine() {
        Pattern pattern = Pattern.compile("([abc]+)"); // когда + внутри группы - создастся 1 группа со значением cab
//        Pattern pattern = Pattern.compile("([abc])+"); // когда + следующий после группы, то создастся группа со значением c, потом она перезапишется на A и потом перезапишится на b
        Matcher matcher = pattern.matcher("cab");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyNine1() {
        System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1\\b", "$1"));
    }

    @Test
    public void twentyNine2() {
        Pattern pattern = Pattern.compile("[(a)b]"); // () внутри квадратных скобок воспринимаются буквально и не создают групп
        Matcher matcher = pattern.matcher("abc()");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyNine3() {
//        чтобы задать имя группе, нужно после открытой ( написать ?<groupName> где groupName - имя группы
//        чтобы обращаться к группе по имени, нужно написать \\k<groupName>
        Pattern pattern = Pattern.compile("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>>"); // вместо \\1 подставится то, что было первым найдено 1-й группой, а это <B>
        Matcher matcher = pattern.matcher("Testing <B><I>bold italic</I></B> text");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void twentyNine4() {
//       чтобы обратится к группе через её имя не в Pattern.compile - нужно использовать ${groupName}
        System.out.println("abc".replaceAll("(?<Aletter>a)", "${Aletter}-"));
    }

    @Test
    public void thirty() {
        Pattern pattern = Pattern.compile(""); // находит текст до () + группу + после группы
        Matcher matcher = pattern.matcher("");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }

    @Test
    public void thirtyOne() {
        Pattern pattern = Pattern.compile(""); // находит текст до () + группу + после группы
        Matcher matcher = pattern.matcher("");
        while (matcher.find()) {
            System.out.println(String.format("%s %s %s", matcher.start(), matcher.end() - 1, matcher.group()));
        }
    }
}