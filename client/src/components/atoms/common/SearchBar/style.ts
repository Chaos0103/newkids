import styled from 'styled-components';
import { SearchBarSizeStyles } from 'styles/styles';

interface ISearchBarContainerProps {
	$size: 's' | 'l' | 'full';
}

export const SearchBarContainer = styled.div<ISearchBarContainerProps>`
	position: relative;

	input {
		padding: 0 60px 0 20px;
		border: 1px solid var(--sub-color-1);
		${({ $size }) => SearchBarSizeStyles[$size]};
		border-radius: var(--radius-l);
		height: 40px;

		&:focus-visible {
			outline: 1.5px solid var(--sub-color-1);
		}
	}
	.confirm-search-btn-wrapper {
		position: absolute;
		top: 0;
		right: 0;
		width: 45px;
		height: 100%;
		border: 1px solid var(--sub-color-1);
		background-color: var(--sub-color-1);
		border-radius: 0 var(--radius-l) var(--radius-l) 0;

		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;

		svg {
			fill: var(--white-color);
			width: 20px;
			height: 20px;

			&:hover {
				width: 25px;
				height: 25px;
			}
		}
	}
`;
