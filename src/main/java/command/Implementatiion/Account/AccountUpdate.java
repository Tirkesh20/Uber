package command.Implementatiion.Account;

import Services.Implementation.AccountService;
import command.Command;
import command.Page;
import entities.Account;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AccountUpdate implements Command {
private AccountService accountService=new AccountService();
private accFetcher accFetcher =new accFetcher();
private final Page page=new Page();

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Account entity = accFetcher.fetchAcc(request);
        accountService.update(entity);
        page.setUrl("login.jsp");
        page.setRedirect(true);
        return new Page();
    }
}
