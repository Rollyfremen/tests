package testmai;


import org.junit.jupiter.api.Test;


public class WebTablePage extends Logic {

        @Test
        public void case0() {
           mainPage
                   .goToPizzaSection()//переходим в раздел пиццы
                   .countProducts()// считаем кол-во
                   .definingRegion();// сверяем регион
        }
       @Test
        public void case1() {
           mainPage
                   .goToPizzaSection()//переходим в раздел пиццы
                   .addRandomItem();//выбираем случайную пиццу
           pizzaPage.setPrice(mainPage.getPrice());//вытаскиваем необходимый текст что бы проверить соответсвие
           pizzaPage
                   .clicSimplButton()//выбираем маленькая
                   .clicAddButton();//нажимаем добавить
           dopPage
                   .сhooseRestaurant()//выбираем ресторан
                   .pressPickupButton();//нажимаем кнопку выбрать
           mainPage.checkingTheShoppingCart();
       }
        @Test
                public  void case2(){
            mainPage.goToPizzaSection().addRandomItemLoop();
            pizzaPage.clicSimplButtonLoop().clicAddButtonLoop();
            dopPage.сhooseRestaurant().pressPickupButton();
            for (int i = 0; i < 4; i++) {
                mainPage
                        .goToPizzaSection()
                        .addRandomItemLoop();
                pizzaPage
                        .clicSimplButtonLoop()
                        .clicAddButtonLoop();
            }//добавляем случайные 5 пицц
            mainPage
                    .carcheckingTheShoppingCartLopp()
                    .basketClicl();//переходим в корзину
            basketPage
                    .theAmountIsVisible();//выводим общую сумму
            }
            @Test
    public void case3() {

            mainPage
                    .contactClicl();//переходим в контакты
            kontacPage
                    .checkingTheNumber().checkingMail();//сверяем телефон и почту

            }

}















