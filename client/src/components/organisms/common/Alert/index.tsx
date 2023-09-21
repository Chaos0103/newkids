import React from 'react';
import Swal from 'sweetalert2';
import Button from 'components/atoms/common/Button';
import { AlertContainer } from './style';

interface IAlertProps {
	imageUrls: string;
	imageHeights: number;
	titles: string;
	texts: string;
}

function Alert({ imageUrls, imageHeights, titles, texts }: IAlertProps) {
	const alert = () =>
		Swal.fire({
			imageUrl: imageUrls,
			imageHeight: imageHeights,
			title: titles,
			text: texts,
		});
	return (
		<AlertContainer>
			<Button size="s" radius="m" color="Primary" text="제출" handleClick={alert} />
		</AlertContainer>
	);
}

export default Alert;
