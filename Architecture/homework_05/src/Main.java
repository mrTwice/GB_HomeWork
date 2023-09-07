import App.Core.ConsoleView;
import App.Core.MainPresenter;
import App.MVP.Presenter;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new MainPresenter();
        presenter.runEntryMenuLogic();
    }
}