package Patterns;

import java.util.LinkedList;

import Messages.*;


public class InsultServiceAux implements InsultService {
	private LinkedList<String> insultList;

    /**
     * Model.InsultServiceImp constructor
     */
    public InsultServiceAux(){
    	insultList = new LinkedList<>();
    }

    /**
     * Add insult to the list
     *
     * @param insult
     */
    public void addInsult(InterfaceMessage insult) {
    	insultList.add(insult.getMessage());
    }

    /**
     * @return random insult
     */
    public InterfaceMessage getInsult() {
    	int random = (int)(Math.random()*50+1);
		if (insultList.size() == 0){
			return new Message (null, "");
		}
		else{
			random = random % insultList.size();
			String randomMessage = insultList.get(random);
			return new Message (null, randomMessage);
		}
    }

    /**
     * @return all insultList
     */
    public LinkedList<String> getAllInsults() {
        return insultList;
    }
}
