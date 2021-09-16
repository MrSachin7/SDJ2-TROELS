import model.TextConverter;
import model.TextConverterModel;
import view.uppercase.log.LogViewModel;



public class test {
    public static void main(String[] args) {
        TextConverter textConverterModel= new TextConverterModel();
        LogViewModel logViewModel = new LogViewModel(textConverterModel);
        String abc = "abc";
        textConverterModel.toUpperCase(abc);
        textConverterModel.toUpperCase("ekko");

        System.out.println(logViewModel.getLogs());

    }
}

