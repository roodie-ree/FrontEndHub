class Grains
  def self.square(number)
    raise ArgumentError unless number >= 1 and number <= 64

    2 ** (number - 1)
  end

  def self.total
    (1..64).sum { |number| square(number) }
  end
end
