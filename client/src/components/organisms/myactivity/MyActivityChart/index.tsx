import React from 'react';
import MyActivityChartGraph from 'components/atoms/myactivity/MyActivityChartGraph';
import MyActivityKeyword from 'components/atoms/myactivity/MyActivityKeywordItem';
import { MyActivityChartContainer } from './style';

function MyActivityChart() {
	return (
		<MyActivityChartContainer>
			<div className="chart-title-text">
				<h3 className="chart-gray-color">내가 본 기사에서는&nbsp;</h3>
				<h3 className="chart-sub-color">이런 키워드가 많아요!</h3>
			</div>
			<div className="chart-keyword-rank">
				<MyActivityKeyword />
			</div>
			<div className="chart-graph-box">
				<MyActivityChartGraph />
			</div>
		</MyActivityChartContainer>
	);
}

export default MyActivityChart;
