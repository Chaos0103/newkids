import React, { useState, useEffect, Dispatch, SetStateAction } from 'react';
import { IArticle } from 'types/article';
import { getAllArticleApi } from 'utils/apis/article';
import Input from 'components/atoms/common/Input';
import Button from 'components/atoms/common/Button';
import { dateToString } from 'utils/common/dateToString';
import { PERIOD_FILTER_LIST } from 'constants/common';
import PeriodFilterItem from 'components/atoms/article/PeriodFilterItem';
import { setDatebyPeriod } from 'utils/common/setDatebyPeriod';
import { SearchOptionsContainer } from './style';

interface ISearchOptionsProps {
	setResultArticles: Dispatch<SetStateAction<IArticle[]>>;
}

function SearchOptions(props: ISearchOptionsProps) {
	const { setResultArticles } = props;
	const [startDate, setStartDate] = useState<string>(dateToString(new Date()));
	const [endDate, setEndDate] = useState<string>(dateToString(new Date()));
	const [selectedPeriod, setSelectedPeriod] = useState(0);

	const search = async () => {
		try {
			const response = await getAllArticleApi(startDate, endDate);
			console.log('::getAllArticleApi', response);

			if (response.status === 200) {
				setResultArticles(response.data.data.content);
			}
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		setStartDate(setDatebyPeriod(selectedPeriod));
		setEndDate(dateToString(new Date()));
	}, [selectedPeriod]);

	return (
		<SearchOptionsContainer>
			<div className="wrapper">
				<div className="left">
					<div className="date-input">
						<Input type="date" value={startDate} setValue={setStartDate} />
						<span> ~ </span>
						<Input type="date" value={endDate} setValue={setEndDate} />
					</div>
					<div className="filter">
						{PERIOD_FILTER_LIST.map((el) => (
							<PeriodFilterItem
								key={el.key}
								filter={el}
								selectedPeriod={selectedPeriod}
								handleClick={() => setSelectedPeriod(el.key)}
							/>
						))}
					</div>
				</div>
				<div className="right">
					<Button color="Primary" size="full" text="검색" handleClick={search} radius="m" />
				</div>
			</div>
		</SearchOptionsContainer>
	);
}

export default SearchOptions;
