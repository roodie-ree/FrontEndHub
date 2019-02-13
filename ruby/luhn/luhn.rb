class Luhn

  def self.valid?(number)
    number
      .delete(' ')
      .tap { |num| return false unless num =~ /^\d{2,}$/ }
      .reverse
      .each_char
      .with_index
      .map { |num, index| index.even? ? num.to_i : num.to_i * 2 }
      .map { |num| num > 9 ? num - 9 : num }
      .sum
      .modulo(10)
      .zero?
  end
end
