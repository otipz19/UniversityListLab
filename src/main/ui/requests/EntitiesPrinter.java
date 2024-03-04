package main.ui.requests;

import DataInputUtil.main.ConsoleDataReader;
import main.model.utils.list.IMyList;
import main.model.utils.pagination.Paginator;
/**
 * This class is used to represent an entities printer.
 * It is a public class because it is used in other packages.
 */
public class EntitiesPrinter {
    public static <T> void printEntities(String header, IMyList<T> entities) {
        System.out.println(header);
        Paginator<T> paginator = new Paginator<>(5, entities);
        System.out.println("Pages in total: " + paginator.getTotalPages() + "\n");
        while(paginator.hasNextPage()){
            IMyList<T> page = paginator.getNextPage();
            System.out.println("Page #" + paginator.getCurPage() + "\n");
            for(int i = 0; i < page.count(); i++){
                int index = ((paginator.getCurPage() - 1) * paginator.getPageSize() + (i + 1));
                System.out.println(index + ". " + page.getAt(i));
            }
            if(paginator.hasNextPage()){
                String input = ConsoleDataReader.getLine("\nInput anything to get next page, or 'stop' to stop\n");
                if(input.equals("stop")){
                    break;
                }
            }
        }
    }
}
