import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        LocalTime opentime = LocalTime.parse("10:30:00") ;
        LocalTime closeTime = LocalTime.parse("22:00:00");
        boolean result ;
        Restaurant restaurant2 = new Restaurant("Scafe","pune",opentime,closeTime ) ;
        LocalTime currenttime = restaurant2.getCurrentTime() ;
        int returnval = currenttime.compareTo(opentime);
        int returnval2 = currenttime.compareTo(closeTime) ;
        if(returnval>=0 && returnval2<=0){
          result= true ;

    }
        else{
          result = false ;
        }
         assertEquals(result, restaurant2.isRestaurantOpen());
        }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        LocalTime opentime = LocalTime.parse("21:30:00") ;
        LocalTime closeTime = LocalTime.parse("22:00:00");
        Restaurant restaurant2 = new Restaurant("Scafe","pune",opentime,closeTime ) ;
        boolean result ;
        LocalTime currenttime = restaurant2.getCurrentTime() ;
        int returnval = currenttime.compareTo(opentime);
        int returnval2 = currenttime.compareTo(closeTime) ;
        if(returnval>=0 && returnval2<=0){
            result= true ;

        }
        else{
            result = false ;
        }
        assertEquals(result, restaurant2.isRestaurantOpen());
    }

    @Test
public void test_show_price(){
        LocalTime opentime = LocalTime.parse("21:30:00") ;
    LocalTime closeTime = LocalTime.parse("22:00:00");
    Restaurant restaurant2 = new Restaurant("Scafe","pune",opentime,closeTime ) ;
    restaurant2.addToMenu("PaneerTikka", 350);
    assertEquals(350 ,restaurant2.showPrice("PaneerTikka"));
}

   @Test
   public void test_orderTotal(){
       LocalTime opentime = LocalTime.parse("21:30:00") ;
       LocalTime closeTime = LocalTime.parse("22:00:00");
       Restaurant restaurant2 = new Restaurant("Scafe","pune",opentime,closeTime ) ;
       restaurant2.addToMenu("Dalfry", 350);
       restaurant2.addToMenu("Paneertikka", 350);
       restaurant2.addToMenu("Aloogobhi", 350);

       ArrayList<String> orders = new ArrayList<>() ;
       orders.add("Dalfry");
       orders.add("Paneertikka");
       orders.add("Aloogobhi");
       assertEquals(1050 , restaurant2.orderTotal(orders));
   }


    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}