package service;

import model.Card;


public class CardCreator
{
    public static final String TESTDATA_CARD_NUMBER = "testdata.card.number";
    public static final String TESTDATA_CARD_CVC = "testdata.card.cvc";
    public static final String TESTDATA_CARD_DATEMONTN = "testdata.card.dateMonth";
    public static final String TESTDATA_CARD_DATEYEAR = "testdata.card.dateYear";


    public static Card withCredentialsFromProperty(){
        return new Card(TestDataReader.getTestData(TESTDATA_CARD_NUMBER),
                TestDataReader.getTestData(TESTDATA_CARD_CVC),
                TestDataReader.getTestData(TESTDATA_CARD_DATEMONTN),
                TestDataReader.getTestData(TESTDATA_CARD_DATEYEAR));
    }
}
