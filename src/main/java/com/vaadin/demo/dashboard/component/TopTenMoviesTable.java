package com.vaadin.demo.dashboard.component;

import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.domain.MovieRevenue;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.ui.Table;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public final class TopTenMoviesTable extends Table {

    public TopTenMoviesTable() {
        setCaption("Top 10 Critical Task");

        addStyleName(ValoTheme.TABLE_BORDERLESS);
        addStyleName(ValoTheme.TABLE_NO_STRIPES);
        addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
        addStyleName(ValoTheme.TABLE_SMALL);
        setSortEnabled(false);
        setColumnAlignment("revenue", Align.RIGHT);
        setRowHeaderMode(RowHeaderMode.INDEX);
        setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
        setSizeFull();

        List<MovieRevenue> movieRevenues = new ArrayList<MovieRevenue>(
                DashboardUI.getDataProvider()
                           .getTotalMovieRevenues());
        movieRevenues.sort((o1, o2) -> o2.getRevenue()
                                         .compareTo(o1.getRevenue()));

        setContainerDataSource(new BeanItemContainer<MovieRevenue>(
                MovieRevenue.class, movieRevenues.subList(0, 10)));

        setVisibleColumns("title", "revenue");
        setColumnHeaders("Title", "Revenue");
        setColumnExpandRatio("title", 2);
        setColumnExpandRatio("revenue", 1);

        setSortContainerPropertyId("revenue");
        setSortAscending(false);
    }

    @Override
    protected String formatPropertyValue(final Object rowId, final Object colId,
                                         final Property<?> property) {
        String result = super.formatPropertyValue(rowId, colId, property);
        if (colId.equals("revenue")) {
            if (property != null && property.getValue() != null) {
                Double r = (Double) property.getValue();
                String ret = new DecimalFormat("#.##").format(r);
                result = "" + ret;
            } else {
                result = "";
            }
        }
        return result;
    }

}
