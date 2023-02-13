fun main() 
{
    print("Welcome to your banking app")
    print("\nwhat type of account would you like to create ?")
    print("\n1. Debit account")
    print("\n2. Credit account")
    print("\n3. Checking account")

    var accountType = ""
    var userChoice : Int
    
    while(accountType == "")
    {
        
        print("\nchoose an option (1, 2 or 3)")
        userChoice = (1..5).random()
        println("\nyour selected option is " + userChoice)
        when(userChoice)
        {
            1 -> accountType="Debit account"
            2 -> accountType="Credit account"            
            3 -> accountType="Cheking account"
            else -> continue
        }
        print("\nyou have chosen account type " + accountType)
    }

    // part 2

    var accountBalance = (1..1000).random()
    println("The checking balance is ${accountBalance} dollars.")
    val money = (1..1000).random()
    println("The amount you transferred is ${money} dollars.")

    fun withdraw(amount: Int): Int
    {
        accountBalance-=amount
        println("you have withdrawn from bank account is " + amount )
        println("remaining balance is " + accountBalance)

        return amount
    }

    fun debitWithdraw(amount: Int): Int
    {
        if (accountBalance == 0)
        {
            print("you dont have enough money")
            return 0 
        }
        else if(amount > accountBalance)
        {
            print("you don't have enough money")
            return 0 
        }
        else
        {
            return withdraw(amount)
        }
    }
    
    fun deposit(amount: Int): Int
    {
        accountBalance+=amount
        println("you have withdrawn from bank account is " + amount )
        println("remaining balance is " + accountBalance)

        return amount
    }
    
    fun creditDeposit(amount: Int): Int
    {
        if (accountBalance == 0)
        {
            print("you don't need to deposit anything")
            return 0 
        }
        else if(amount + accountBalance > 0)
        {
            print("you are over paying")
            return 0 
        }
        else if(amount + accountBalance == 0)
        {
            print("done")
            return amount+accountBalance 
        }
        else
        {
            return deposit(amount)
        }
    }

    // part 3

    fun  transfer(mode: String)
    {
        val transferAmount: Int
        when(mode)
        {
            "deposit" ->
            {
                if(accountType == "Credit account")
                transferAmount = creditDeposit(money)
                else
                transferAmount = deposit(money)
                println("The amount you deposit is ${transferAmount} .")
            }
            "withdraw" ->
            {
                if(accountType == "Debit account")
                transferAmount = debitWithdraw(money)
                else
                transferAmount = withdraw(money)
                println("The amount you withdrew is ${transferAmount}.")
            }
            else -> return 
        }
    }

    var isSystemOpen = true
    var option : Int

    while(isSystemOpen == true)
    {
        print("What would you like to do?")
        print("\n1. Check bank account balance")
        print("\n2. Withdraw money")
        print("\n3. Deposit money")
        print("\n4. Close the app")
        print("Which option do you choose? (1, 2, 3 or 4)")
        option = (1..5).random()
        print(option)
        when(option)
        {
            1 -> println("Your account balance :"+ accountBalance)
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> isSystemOpen = false
            else -> continue
        }
    }
}