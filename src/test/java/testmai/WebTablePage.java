package testmai;


import org.junit.jupiter.api.Test;



public class WebTablePage extends Logic {

        @Test
        public void Pofroll() {
           searchPage
                   .cliclpizza()//нажимаем на раздел пицца
                   .kolpizza()//считает количество товаров в разделе пицца
                   .reg();
        }
    }


