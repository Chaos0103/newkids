import styled, { css } from 'styled-components';

const colorSet = {
	Primary: css`
		color: var(--main-color);
	`,
	SubFirst: css`
		color: var(--sub-color-1);
	`,
	Black: css`
		color: var(--black-500);
	`,
};

interface IAreaTitleWrapperProps {
	$color: 'Primary' | 'SubFirst' | 'Black';
}

export const AreaTitleWrapper = styled.h2<IAreaTitleWrapperProps>`
	display: flex;
	flex-direction: row;
	gap: 0.5rem;
	align-items: center;
	font-size: 1.5rem;
	font-weight: bold;
	padding: 1rem 0;

	${({ $color }) => colorSet[$color]};

	.subStr {
		color: var(--gray-300);
	}
`;
