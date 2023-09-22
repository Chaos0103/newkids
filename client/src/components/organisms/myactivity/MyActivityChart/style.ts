import styled from 'styled-components';

export const MyActivityChartContainer = styled.div`
	.chart-title-text {
		display: flex;
		font-weight: bold;

		> .chart-sub-color {
			color: var(--sub-color-1);
			font-size: 24px;
		}

		> .chart-gray-color {
			color: var(--gray-500);
			font-size: 24px;
		}
	}

	.my-activity-chart-graph {
		background-color: var(--sub-color-2);
	}
`;
