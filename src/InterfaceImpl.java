package com.nekashop.app.test;

public class InterfaceImpl  implements  Random{
    @Override
    public void setHomeTeam(String name) {

    }

    @Override
    public void setVisitingTeam(String name) {

    }

    @Override
    public void setRandomName(String name) {

    }

    @Override
    public void homeTeamScored(int points) {

    }

    @Override
    public void visitingTeamScored(int points) {

    }

    @Override
    public void endOfQuarter(int quarter) {

    }

    @Override
    public void homeGoalScored() {

    }

    @Override
    public void visitingGoalScored() {

    }

    @Override
    public void endOfPeriod(int period) {

    }

    @Override
    public void overtimePeriod(int ot) {

    }
}
 interface Sports {
    public void setHomeTeam(String name);
    public void setVisitingTeam(String name);
}

interface Random extends Sports, Hockey, Football {
    public void setRandomName(String name);

}

 interface Football extends Sports {
    public void homeTeamScored(int points);
    public void visitingTeamScored(int points);
    public void endOfQuarter(int quarter);
}

 interface Hockey extends Sports {
    public void homeGoalScored();
    public void visitingGoalScored();
    public void endOfPeriod(int period);
    public void overtimePeriod(int ot);
}