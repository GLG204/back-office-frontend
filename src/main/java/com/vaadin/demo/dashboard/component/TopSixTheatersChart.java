package com.vaadin.demo.dashboard.component;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.data.dummy.DummyDataGenerator;
import com.vaadin.demo.dashboard.domain.Movie;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TopSixTheatersChart extends Chart {

    public TopSixTheatersChart() {
        super(ChartType.PIE);

        setCaption("Most SIP instance Traffic");
        getConfiguration().setTitle("");
        getConfiguration().getChart()
                          .setType(ChartType.PIE);
        getConfiguration().getChart()
                          .setAnimation(false);
        setWidth("100%");
        setHeight("90%");

        DataSeries series = new DataSeries();

        List<Movie> movies = new ArrayList<Movie>(DashboardUI.getDataProvider()
                                                             .getMovies());
        for (int i = 0; i < 6; i++) {
            Movie movie = movies.get(i);
            DataSeriesItem item = new DataSeriesItem(movie.getTitle(),
                    movie.getScore());
            series.add(item);
            item.setColor(DummyDataGenerator.chartColors[5 - i]);
        }
        getConfiguration().setSeries(series);

        PlotOptionsPie opts = new PlotOptionsPie();
        opts.setBorderWidth(0);
        opts.setShadow(false);
        opts.setAnimation(false);
        getConfiguration().setPlotOptions(opts);

        Credits c = new Credits("");
        getConfiguration().setCredits(c);
    }

}
