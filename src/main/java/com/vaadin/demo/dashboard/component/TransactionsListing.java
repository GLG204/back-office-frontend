package com.vaadin.demo.dashboard.component;

import com.vaadin.demo.dashboard.domain.Transaction;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

@SuppressWarnings("serial")
public class TransactionsListing extends CssLayout {

    private final DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

    public TransactionsListing(final Collection<Transaction> transactions) {
        addComponent(new Label("<strong>Selected transactions</strong>",
                ContentMode.HTML));

        if (transactions != null) {
            for (Transaction transaction : transactions) {
                CssLayout translationLayout = new CssLayout();
                translationLayout.addStyleName("transaction");

                Label content = new Label(df.format((transaction.getTime()))
                        + "<br>" + transaction.getCity() + ", "
                        + transaction.getCountry());
                content.setSizeUndefined();
                content.setContentMode(ContentMode.HTML);
                content.addStyleName("time");
                translationLayout.addComponent(content);

                content = new Label(transaction.getTitle());
                content.setSizeUndefined();
                content.addStyleName("movie-title");
                translationLayout.addComponent(content);

                content = new Label("Seats: "
                        + transaction.getSeats()
                        + "<br>"
                        + "Revenue: $"
                        + new DecimalFormat("#.##").format(transaction
                        .getPrice()), ContentMode.HTML);
                content.setSizeUndefined();
                content.addStyleName("seats");
                translationLayout.addComponent(content);

                addComponent(translationLayout);
            }

        }
    }

}
